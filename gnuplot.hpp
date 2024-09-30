/*
`Gnuplot`はgnuplotを使用して図形を描画するためのクラスである．
このクラスは次のようにして利用する：

  1. `#inclulde "gnuplot.hpp"`を追加する
  2. `Gnuplot`型オブジェクトを構築する
  3. `add_...`メンバ関数を呼び出して描画したい図形を登録する
  4. 図形の登録が全て終わったら、`draw`メンバ関数を呼び出す
    - gnuplotにより描画されたウィンドウが表示される
    - 登録された全ての図形が描画される

図形を登録する`add_...`メンバ関数には多くの種類がある：

  - add_point：点を登録する
    * 引数：Point
  - add_points：点集合を登録する
    * 引数：Pointのコンテナ（std::vector<Point>など）
    * 引数：点1, 点2, ...
  - add_polygon：多角形を登録する
    * 引数：Pointのコンテナ（std::vector<Point>など）
    * 引数：点1, 点2, 点3, ...
  - add_polyline：折れ線を登録する
    * 引数：Pointのコンテナ（std::vector<Point>など）
    * 引数：点1, 点2, ...
  - add_circle：円を登録する
    * 引数：Point（円の中心）, 実数値（円の半径）

なお，Point型はデータメンバx, yを持っている必要がある．

以下のコードを実行すると多角形（星）と円が描画される：

    #include <iostream>
    #include <vector>

    #include "gnuplot.hpp"

    struct Point
    {
        double x;
        double y;
    };

    int main()
    {
        std::vector<Point> star = {
            {0.927975, 0.639058}, {0.601031, 0.639058}, 
            {0.500000, 0.950000}, {0.398969, 0.639058}, 
            {0.072025, 0.639058}, {0.336528, 0.446885}, 
            {0.235497, 0.135942}, {0.500000, 0.328115}, 
            {0.764503, 0.135942}, {0.663472, 0.446885}, 
        };
        Point center = {0.5, 0.5};
        double radius = 0.5;
    
        Gnuplot plotter;
        plotter.add_polygon(star);
        plotter.add_circle(center, radius);
        plotter.draw();
    }
*/

#ifndef GNUPLOT_HPP
#define GNUPLOT_HPP

#include <cstdio>
#include <stdio.h> // popen

#include <memory>
#include <string>

class Gnuplot
{
private:
    std::shared_ptr<std::FILE> gnuplot_pipe_;
    std::string cmd_buf_;
    std::string data_buf_;

public:
    Gnuplot()
      : gnuplot_pipe_(popen("\"C:/Program Files/gnuplot/bin/gnuplot\" --persist", "w"), pclose)
    {
        std::fprintf(gnuplot_pipe_.get(), "unset xtics\n");
        std::fprintf(gnuplot_pipe_.get(), "unset ytics\n");
        std::fprintf(gnuplot_pipe_.get(), "unset border\n");
        std::fprintf(gnuplot_pipe_.get(), "set size ratio -1\n");
        std::fprintf(gnuplot_pipe_.get(), "set style circle radius screen 0.006\n");
        std::fprintf(gnuplot_pipe_.get(), "set style circle noclip\n");
        std::fflush(gnuplot_pipe_.get());
        
        cmd_buf_.reserve(8192);
        data_buf_.reserve(8192);
    }
    
    void set_xrange(double x_min, double x_max) const
    {
        std::fprintf(gnuplot_pipe_.get(), "set xrange[%f:%f]\n", x_min, x_max);
        std::fflush(gnuplot_pipe_.get());
    }
    
    void set_yrange(double y_min, double y_max) const
    {
        std::fprintf(gnuplot_pipe_.get(), "set yrange[%f:%f]\n", y_min, y_max);
        std::fflush(gnuplot_pipe_.get());
    }
    
    void eval(char const* str) const
    {
        std::fprintf(gnuplot_pipe_.get(), "%s\n", str);
        std::fflush(gnuplot_pipe_.get());
    }
    
    template <typename Point>
    void add_circle(Point const& center, double radius)
    {
        emit_plot_cmd();
        
        cmd_buf_ += "'-'  with circles  lw 6  notitle";
        
        auto ctr_x = center.x;
        auto ctr_y = center.y;
        data_buf_ += std::to_string(ctr_x + radius) + " " + std::to_string(ctr_y)          + " 0.0\n";
        data_buf_ += std::to_string(ctr_x)          + " " + std::to_string(ctr_y + radius) + " 0.0\n";
        data_buf_ += std::to_string(ctr_x - radius) + " " + std::to_string(ctr_y)          + " 0.0\n";
        data_buf_ += std::to_string(ctr_x)          + " " + std::to_string(ctr_y - radius) + " 0.0\n";
        data_buf_ += std::to_string(ctr_x)          + " " + std::to_string(ctr_y)          + " ";
        data_buf_ += std::to_string(radius) + "\n";
        data_buf_ += "e\n";
    }
    
    template <typename Points>
    void add_polygon(Points const& pts)
    {
        emit_plot_cmd();
        
        cmd_buf_ += "'-'  with lines  lw 6  notitle";
        
        for (auto&& p : pts) {
            data_buf_ += std::to_string(p.x) + " " + std::to_string(p.y) + "\n";
        }
        
        auto&& p = *std::begin(pts);
        data_buf_ += std::to_string(p.x) + " " + std::to_string(p.y) + "\n";
        data_buf_ += "e\n";
    }
    
    template <typename Point, typename... Args>
    void add_polygon(Point const& p0, Point const& p1, Point const& p2, Args const&... args)
    {
        Point points[] = {p0, p1, p2, args...};
        add_polygon(points);
    }
    
    template <typename Points>
    void add_polyline(Points const& pts)
    {
        emit_plot_cmd();
        
        cmd_buf_ += "'-'  with lines  lw 6  notitle";
        
        for (auto&& p : pts) {
            data_buf_ += std::to_string(p.x) + " " + std::to_string(p.y) + "\n";
        }
        data_buf_ += "e\n";
    }
    
    template <typename Point, typename... Args>
    void add_polyline(Point const& p0, Point const& p1, Args const&... args)
    {
        Point points[] = {p0, p1, args...};
        add_polyline(points);
    }
    
    template <typename Point>
    void add_point(Point const& p)
    {
        emit_plot_cmd();
        
        cmd_buf_ += "'-'  with circles  fs solid border lc black lw 2  notitle";
        
        data_buf_ += std::to_string(p.x) + " " + std::to_string(p.y) + "\n";
        data_buf_ += "e\n";
    }
    
    template <typename Points>
    void add_points(Points const& pts)
    {
        emit_plot_cmd();
        
        cmd_buf_ += "'-'  with circles  fs solid border lc black lw 2  notitle";
        
        for (auto&& p : pts) {
            data_buf_ += std::to_string(p.x) + " " + std::to_string(p.y) + "\n";
        }
        data_buf_ += "e\n";
    }
    
    template <typename Point, typename... Args>
    void add_points(Point const& p0, Point const& p1, Args const&... args)
    {
        Point points[] = {p0, p1, args...};
        add_points(points);
    }
    
    void draw()
    {
        std::fprintf(gnuplot_pipe_.get(), "%s\n", cmd_buf_.c_str());
        std::fprintf(gnuplot_pipe_.get(), "%s", data_buf_.c_str());
        std::fflush(gnuplot_pipe_.get());
        
        clear_buffer();
    }
    
private:
    void emit_plot_cmd()
    {
        bool is_first_item = cmd_buf_.empty();
        
        if (is_first_item) {
            cmd_buf_ += "plot ";
        }
        else {
            cmd_buf_ += ",\\\n";
        }
    }
    
    void clear_buffer()
    {
        cmd_buf_.clear();
        data_buf_.clear();
    }
};

#endif
