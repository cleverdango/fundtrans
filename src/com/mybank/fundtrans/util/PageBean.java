package com.mybank.fundtrans.util;

import java.util.List;

/**
 * Created by yazawanico on 2017/3/26.
 */
public class PageBean {
    public int curPage;//当前页码
    public int maxPage;
    public int maxRowCount;
    public int rowsPerPage = 10;
    public List data;
    public void countMaxPage() {
        if (this.maxRowCount % this.rowsPerPage == 0) {
            this.maxPage = this.maxRowCount / this.rowsPerPage;

        } else {
            this.maxPage = this.maxRowCount / this.rowsPerPage + 1;
        }

    }

    public int getCurPage() {
        return curPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public int getMaxRowCount() {
        return maxRowCount;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public List getData() {
        return data;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public void setMaxRowCount(int maxRowCount) {
        this.maxRowCount = maxRowCount;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public void setData(List data) {
        this.data = data;
    }
}
