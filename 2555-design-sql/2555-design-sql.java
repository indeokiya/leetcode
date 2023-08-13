class SQL {
    Map<String, Integer> tableIds;
    List<String> tableNames;
    List<Integer> columnNums;
    List<TableMetadata> tables;

    public SQL(List<String> names, List<Integer> columns) {
        this.tableIds = new HashMap<>();
        this.tableNames = new ArrayList<>(names);
        this.columnNums = new ArrayList<>(columns);
        this.tables = new ArrayList<>();
        for (int i=0; i<names.size(); i++) {
            tableIds.put(names.get(i), i);
            tables.add(new TableMetadata(i, columns.get(i)));
        }
    }
    
    public void insertRow(String name, List<String> row) {
        TableMetadata table = tables.get(tableIds.get(name));
        table.insert(row);
    }
    
    public void deleteRow(String name, int rowId) {
        TableMetadata table = tables.get(tableIds.get(name));
        table.delete(rowId-1);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        return tables.get(tableIds.get(name)).select(rowId-1, columnId-1);
    }
}

class TableMetadata {
    boolean tableDeleted;
    int tableId;
    int numOfRows;
    int numOfColumns;
    List<String> columns;
    List<Boolean> rowDeleted;
    List<List<String>> rows;
    
    public TableMetadata(int tableId, int numOfColumns) {
        this.tableDeleted = false;
        this.tableId = tableId;
        this.numOfRows = 0;
        this.numOfColumns = numOfColumns;
        this.columns = new ArrayList<>();
        this.rowDeleted = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void insert(List<String> row) {
        rowDeleted.add(false);
        rows.add(row);
        ++numOfRows;
    }

    public void delete(int rowId) {
        rowDeleted.set(rowId, true);
    }

    public String select(int rowId, int colId) {
        return rows.get(rowId).get(colId);
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */