package com.weidong.blog.commons.until;

import java.io.Serializable;

/**
 *分页数据信息： PageObject
 */
public class PageObject implements Serializable {


	private static final long serialVersionUID = 1L;
	/**
     * 当前页
     */
	private int pageCurrent = 1;
    /**
     * 每页记录数（默认每页3条）
     */
    private int pageSize =2;
    /**
     * 总的记录数
     */
    private int rowCount;
    
    /**
     * 开始显示记录
     */
	private int startIndex;
    
    //总页数
	private int pageCount;
    public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageCount() {
    	int pages = rowCount/pageSize;
    	if(0 != rowCount%pageSize) {
    		pages +=1;
    	}
        return pages;
    }
	public int getPageCurrent() {
	        return pageCurrent;
	}
    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    
    public void setStartIndex(int startIndex) {
    	this.startIndex = startIndex;
    }

    public int getStartIndex() {
    	return (this.getPageCurrent()-1)*pageSize;
    }
    
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", startIndex=" + startIndex + ", pageCount=" + pageCount + "]";
	}
}
