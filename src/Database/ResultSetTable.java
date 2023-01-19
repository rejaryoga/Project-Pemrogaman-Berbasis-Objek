package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

//class yang mendeklarasikan fungsi untuk mengambil nilai pada tabel
public class ResultSetTable extends AbstractTableModel {

    private ResultSet rs;
    
    //kontruktor Class Result
    public ResultSetTable(ResultSet rs) {
        this.rs = rs;
        //fireTableDataChanged();
    }
    
    //mengambil nilai kolom pada tabel
    public int getColumnCount() {
        try {
            if (rs == null) {
                return 0;
            } else {
                return rs.getMetaData().getColumnCount();
            }
        } catch (SQLException e) {
            System.out.println("resultset generating error while getting column count");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    //mengambil nilai baris pada tabel
    public int getRowCount() {
        try {
            if (rs == null) {
                return 0;
            } else {
                rs.last();
                return rs.getRow();
            }
        } catch (SQLException e) {
            System.out.println("resultset generating error while getting rows count");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    //mengambil nilai pda kolom dan baris tertentu
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex > getRowCount()
                || columnIndex < 0 || columnIndex > getColumnCount()) {
            return null;
        }
        try {
            if (rs == null) {
                return null;
            } else {
                rs.absolute(rowIndex + 1);
                return rs.getObject(columnIndex + 1);
            }
        } catch (SQLException e) {
            System.out.println("resultset generating error while fetching rows");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    //mengambil Nama suatu kolom
    public String getColumnName(int columnIndex) {
        try {
            return rs.getMetaData().getColumnName(columnIndex + 1);
        } catch (SQLException e) {
            System.out.println("resultset generating error while fetching column name");
            System.out.println(e.getMessage());
        }
        return super.getColumnName(columnIndex);
    }

}

