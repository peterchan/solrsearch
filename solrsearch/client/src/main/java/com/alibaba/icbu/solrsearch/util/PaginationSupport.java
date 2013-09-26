package com.alibaba.icbu.solrsearch.util;

import java.util.LinkedList;
import java.util.List;

/**
 * solr������� ��ҳ֧���� <br/>
 * 2009-12-12 23:01
 * 
 * @author chenwei
 * @version 0.1
 */

public class PaginationSupport<T> {

    // ---------------------------------------------------------

    // static variables

    // ---------------------------------------------------------

    // Ĭ��ÿҳ��ʾ����

    public static final int    DEFAULT_MAX_PAGE_ITEMS        = 10;

    // Ĭ�Ͽ�ʼ��¼����

    public static final int    DEFAULT_OFFSET                = 0;

    // Ĭ����ʾҳ�������

    public static final int    DEFAULT_MAX_INDEX_PAGES       = 10;

    // Ĭ�Ϸ�ҳ��ʾ�����ҳ��

    public static final int    DEFAULT_MAX_PAGE_INDEX_NUMBER = 12;

    // index Ϊ����ҳλ��, ����ѡ�� "center", "forward", "half-full"

    public static final String DEFALUT_INDEX                 = "center";

    // ---------------------------------------------------------

    // memeber variables

    // ---------------------------------------------------------

    // ��ʼ��¼����

    private int                offset                        = 0;

    // ÿҳ��ʾ����

    private int                maxPageItems                  = DEFAULT_MAX_PAGE_ITEMS;

    // ��ʾҳ�������

    private int                maxIndexPages                 = DEFAULT_MAX_INDEX_PAGES;

    // ��ҳ��ʾ�����ҳ��

    private int                maxPageIndexNumber            = DEFAULT_MAX_PAGE_INDEX_NUMBER;

    // �ܼ�¼��

    private int                totalCount;

    // ��ҳ��

    private int                totalPage;

    // ��ǰҳ

    private int                currentPage;

    // ���ؽ����

    private List<T>            items                         = new LinkedList<T>();

    // index Ϊ����ҳλ��, ����ѡ�� "center", "forward", "half-full"

    private String             index                         = DEFALUT_INDEX;

    // ҳ������

    private int[]              pages                         = new int[0];

    private int[]              indexes                       = new int[0];

    public PaginationSupport() {

        setMaxIndexPages(DEFAULT_MAX_INDEX_PAGES);

        setTotalCount(0);

        setOffset(0);

        setItems(new LinkedList<T>());

    }

    public PaginationSupport(List<T> items, int totalCount) {

        setMaxPageItems(DEFAULT_MAX_PAGE_ITEMS);

        setTotalCount(totalCount);

        setItems(items);

        setOffset(PagerFacade.getOffset());

    }

    public PaginationSupport(List<T> items, int totalCount, int offset) {

        setMaxPageItems(DEFAULT_MAX_PAGE_ITEMS);

        setTotalCount(totalCount);

        setItems(items);

        setOffset(offset);

    }

    public PaginationSupport(List<T> items, int totalCount, int offset,

    int maxPageItems) {

        setMaxPageItems(maxPageItems);

        setTotalCount(totalCount);

        setItems(items);

        setOffset(offset);

    }

    public PaginationSupport(List<T> items, int totalCount, int offset,

    int maxPageItems, int maxIndexPages, String index) {

        setMaxPageItems(maxPageItems);

        setTotalCount(totalCount);

        setItems(items);

        setOffset(offset);

        setMaxIndexPages(maxIndexPages);

        setIndex(index);

    }

    public List<T> getItems() {

        return items;

    }

    public void setItems(List<T> items) {

        if (items == null) {

            this.items = new LinkedList<T>();

        } else {

            this.items = items;

        }

    }

    public int getMaxPageItems() {

        return maxPageItems;

    }

    public void setMaxPageItems(int maxPageItems) {

        this.maxPageItems = maxPageItems;

    }

    public int getTotalCount() {

        return totalCount;

    }

    public void setTotalCount(int totalCount) {

        if (totalCount > 0) {

            this.totalCount = totalCount;

            int count = totalCount / maxPageItems;

            if (totalCount % maxPageItems > 0) {

                count++;

            }

            this.totalPage = count;

            indexes = new int[count];

            for (int i = 0; i < count; i++) {

                indexes[i] = maxPageItems * i;

            }

        } else {

            this.totalCount = 0;

        }

    }

    public int[] getPages() {

        return pages;

    }

    public void setPages(int[] pages) {

        this.pages = pages;

    }

    public int getOffset() {

        return offset;

    }

    public void setOffset(int startIndex) {

        if (totalCount <= 0)

        this.offset = 0;

        else if (startIndex >= totalCount)

        this.offset = indexes[indexes.length - 1];

        else if (startIndex < 0)

        this.offset = 0;

        else {

            this.offset = indexes[startIndex / maxPageItems];

        }

        this.currentPage = offset / maxPageItems + 1;

        if (totalPage > maxPageIndexNumber) {

            pages = new int[maxPageIndexNumber];

            pages[0] = 1;

            if (this.currentPage < maxPageIndexNumber / 2) {

                for (int i = 1; i <= maxPageIndexNumber - 3; i++) {

                    pages[i] = i + 1;

                }

                pages[maxPageIndexNumber - 2] = 0;

            } else if (this.currentPage > maxPageIndexNumber / 2

            && this.currentPage < (totalPage - maxPageIndexNumber / 2)) {

                int tmp = (maxPageIndexNumber - 2) / 2;

                pages[1] = 0;

                for (int i = 2; i <= maxPageIndexNumber - 3; i++) {

                    pages[i] = currentPage - tmp + i;

                }

                pages[maxPageIndexNumber - 2] = 0;

            } else {

                pages[1] = 0;

                for (int i = 2; i <= maxPageIndexNumber - 2; i++) {

                    pages[i] = totalPage - maxPageIndexNumber + i + 1;

                }

            }

            pages[maxPageIndexNumber - 1] = totalPage;

        } else {

            pages = new int[totalPage];

            for (int i = 0; i < totalPage; i++) {

                pages[i] = i + 1;

            }

        }

    }

    public int getNextIndex() {

        int nextIndex = getOffset() + maxPageItems;

        return nextIndex >= totalCount ? getOffset() : nextIndex;

    }

    public int getPreviousIndex() {

        int previousIndex = getOffset() - maxPageItems;

        return previousIndex < 0 ? DEFAULT_OFFSET : previousIndex;

    }

    /**
     * @return Returns the dEFAULT_MAX_INDEX_PAGES.
     */

    public static int getDEFAULT_MAX_INDEX_PAGES() {

        return DEFAULT_MAX_INDEX_PAGES;

    }

    public int getMaxIndexPages() {

        return maxIndexPages;

    }

    public void setMaxIndexPages(int maxIndexPages) {

        this.maxIndexPages = maxIndexPages;

    }

    public String getIndex() {

        return index;

    }

    public void setIndex(String index) {

        this.index = index;

    }

    public int getMaxPageIndexNumber() {

        return maxPageIndexNumber;

    }

    public void setMaxPageIndexNumber(int maxPageIndexNumber) {

        this.maxPageIndexNumber = maxPageIndexNumber;

    }

    public int getTotalPage() {

        return totalPage;

    }

    public void setTotalPage(int totalPage) {

        this.totalPage = totalPage;

    }

    public int[] getIndexes() {

        return indexes;

    }

    public void setIndexes(int[] indexes) {

        this.indexes = indexes;

    }

    public int getCurrentPage() {

        return currentPage;

    }

    public void setCurrentPage(int currentPage) {

        this.currentPage = currentPage;

    }

    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {

        PaginationSupport<String> ps = new PaginationSupport<String>(null, 30, 10, 10);

        int[] pages = ps.getPages();

        for (int i = 0; i < pages.length; i++) {

            System.out.println(pages[i]);

        }

        System.out.println("_" + ps.getCurrentPage());

    }

}
