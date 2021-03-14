/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Domain.Sales.SalesLineItem;

/**
 *
 * @author lenovo
 */
public class ReceiptTableModel extends AbstractGuiTableModels<SalesLineItem> {
     private final String[] columnNames={"Description","Quantity","Price"};
    private final Class[] columnClasses={String.class,Integer.class,float.class};
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
        SalesLineItem i=list.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return i.getItem().getItemName();
            case 1:
                return i.getQuantity();
            case 2:
                return i.getPacketPrice();
            default:
                return null;
        }
    }
}
