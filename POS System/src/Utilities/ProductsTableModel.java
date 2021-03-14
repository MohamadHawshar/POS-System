/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Domain.Sales.Item;

/**
 *
 * @author lenovo
 */
public class ProductsTableModel extends AbstractGuiTableModels<Item>{

    private final String[] columnNames={"Item ID","Description","Price"};
    private final Class[] columnClasses={Integer.class,String.class,float.class};
    @Override
    public int getColumnCount() {
        return columnClasses.length;
    }
  @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item i=list.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return i.getIdItem();
            case 1:
                return i.getItemName();
            case 2:
                return i.getPrice();
            default:
                return null;
        }
    }
}
