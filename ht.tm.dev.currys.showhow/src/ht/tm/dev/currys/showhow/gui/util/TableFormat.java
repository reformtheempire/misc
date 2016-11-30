package ht.tm.dev.currys.showhow.gui.util;

import java.util.Arrays;

public class TableFormat {

	private String[] tableHeaders;
	private String[][] data;

	public TableFormat(String[] tableHeaders, String[][] data) {
		super();
		this.tableHeaders = tableHeaders;
		this.data = data;
	}

	public String[] getTableHeaders() {
		return tableHeaders;
	}

	public String[][] getData() {
		return data;
	}

	@Override
	public String toString() {
		return "TableFormat [tableHeaders=" + Arrays.toString(tableHeaders) + ", data=" + Arrays.toString(data) + "]";
	}

}
