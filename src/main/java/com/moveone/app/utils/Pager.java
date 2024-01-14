package com.moveone.app.utils;

public class Pager {
    private Long startRow;
    private Long lastRow;
    private Long page;
    private Long perPage = 10L;

    private Long startNum;
    private Long lastNum;
    private Long totalPage;

    private Boolean start;
    private Boolean last;

    private String search;
    private String kind;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getStartNum() {
        return startNum;
    }

    public void setStartNum(Long startNum) {
        this.startNum = startNum;
    }

    public Long getLastNum() {
        return lastNum;
    }

    public void setLastNum(Long lastNum) {
        this.lastNum = lastNum;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public Long getStartRow() {
        return startRow;
    }

    public void setStartRow(Long startRow) {
        this.startRow = startRow;
    }

    public Long getLastRow() {
        return lastRow;
    }

    public void setLastRow(Long lastRow) {
        this.lastRow = lastRow;
    }

    public Long getPage() {
        return (page == null || page < 1)? 1L : page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public void makeRow(){
        this.startRow = 1 + (getPage()-1)*getPerPage();
        this.lastRow = getPage()*getPerPage();
    }

    public void makeBlock(Long totalRow){
        totalPage = (long) Math.ceil((double) totalRow /getPerPage());
        Long perBlock = 5L;

        Long lastBlock = (long) Math.ceil((double) totalPage /perBlock);
        Long currentBlock = (long) Math.floor((double) (getPage() - 1) /perBlock) + 1;

        startNum = 1 + (currentBlock - 1)*perBlock;
        lastNum = currentBlock * perBlock;

        start = (currentBlock == 1L);
        if(currentBlock.equals(lastBlock)){
            last = true;
            lastNum = totalPage;
        }
    }

    @Override
    public String toString() {
        return "Pager{" +
                "startRow=" + startRow +
                ", lastRow=" + lastRow +
                ", page=" + page +
                ", perPage=" + perPage +
                ", startNum=" + startNum +
                ", lastNum=" + lastNum +
                ", totalPage=" + totalPage +
                ", start=" + start +
                ", last=" + last +
                '}';
    }
}
