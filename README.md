常见的算法题
===

# 趣味算法

## 八皇后问题
国际象棋中的皇后，可以横向、纵向、斜向移动。如何在一个8X8的棋盘上放置8个皇后，使得任意两个皇后都不在同一条横线、竖线、斜线方向上？

### 找出指定位置[x, y]斜线上的元素以及纵线上的元素
> 斜线上的元素的索引的和相等或者差相等
> 
> 参考链接：https://blog.csdn.net/friendan/article/details/8809089

### 递归回溯算法

``` java 
    private static boolean mySettleQueen(int r){
        if (r == row){ // 为最后一行设置Queen时返回true，因为这行的结果不会影响其他的行
            return true;
        }
        for (int index = 0; index < col; index++){ // 从第一列遍历到最后一列
            // 当前行元素都清零,为回溯做铺垫
            clearRow(r);
            if (myCheck(r, index)){
                chess[r][index] = 1;
                if (mySettleQueen(r + 1)){// 递归,如果返回false则回溯
                    return true;
                }
            }
        }
        return false;
    }
```

### Java程序结果

```
  0 1 2 3 4 5 6 7 
0 □ ■ □ □ □ □ □ □ 
1 □ □ □ □ ■ □ □ □ 
2 □ □ □ □ □ □ ■ □ 
3 ■ □ □ □ □ □ □ □ 
4 □ □ ■ □ □ □ □ □ 
5 □ □ □ □ □ □ □ ■ 
6 □ □ □ □ □ ■ □ □ 
7 □ □ □ ■ □ □ □ □ 
[0, 1][1, 4][2, 6][3, 0][4, 2][5, 7][6, 5][7, 3]
```