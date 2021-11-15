package kr.or.ddit.vo;

import java.util.List;



/**
 * 전체 페이징 속성을 연산하기 위해, setTotalRecord 와 setCurrentPage 호출 필요.
 *
 */

public class PagingVO<T> {
	
	public PagingVO() {
		super();
	}

	public PagingVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}

	private int totalRecord; 
	private int screenSize = 5;
	private int blockSize = 5;
	private int currentPage;
	
	private int totalPage;
	private int endRow;
	private int startRow;
	private int endPage;
	private int startPage;
	
	
	private List<T> dataList;
	
	private T detailSearch;
	
	// 상세 검색용
	public void setDetailSearch(T detailSearch) {
		this.detailSearch = detailSearch;
	}
	
	// 단순 키워드 검색용 
	private SearchVO searchVO;
	
	public void setSearchVO(SearchVO searchVO) {
		this.searchVO = searchVO;
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (totalRecord + (screenSize-1))/screenSize;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;
		startRow = endRow - (screenSize - 1);

		endPage = blockSize * ((currentPage + (blockSize - 1))/blockSize);
		startPage = endPage - (blockSize - 1);
	}
	
	private static final String PAINGPATTERN = 
			"<li class='page-item %s'><a class='page-link' data-page='%s' href='#' %s>%s</a></li>";
	private static final String CURRENTPATTERN = 
			"<li class='page-item active' aria-current='page'>\n" + 
			"<a class='page-link' href='#'>%d</a>\n" + 
			"</li>";
	
	private String DISABLED = "tabindex='-1' aria-disabled='true'";
	private String ENABLED = "";
	
	public String getPagingHTML() {
		StringBuffer html = new StringBuffer("<nav aria-label='paging'>\n");
		html.append("<ul class='pagination'>\n");
		endPage = endPage > totalPage ? totalPage : endPage;
		if(startPage > blockSize) {
			html.append(String.format(PAINGPATTERN, ENABLED, (startPage - blockSize), ENABLED, "이전"));
		}else {
			html.append(String.format(PAINGPATTERN, "disabled", "", DISABLED, "이전"));
			
		}
		
		for(int page = startPage; page <= endPage; page++) {
			if(page==currentPage) {
				html.append(String.format(CURRENTPATTERN, page));
			}else {
				html.append(String.format(PAINGPATTERN, ENABLED, page, ENABLED, page));
			}
		}
		
		if(endPage < totalPage) {
			html.append(String.format(PAINGPATTERN, ENABLED, (endPage + 1), ENABLED,"다음"));
		}else {
			html.append(String.format(PAINGPATTERN, "disabled", "", DISABLED,"다음"));
		}
		
		html.append("</ul></nav>");
		return html.toString();
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public String getDISABLED() {
		return DISABLED;
	}

	public void setDISABLED(String dISABLED) {
		DISABLED = dISABLED;
	}

	public String getENABLED() {
		return ENABLED;
	}

	public void setENABLED(String eNABLED) {
		ENABLED = eNABLED;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public T getDetailSearch() {
		return detailSearch;
	}
}



