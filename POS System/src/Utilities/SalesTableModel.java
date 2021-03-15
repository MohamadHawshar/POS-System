/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Domain.Sales.Sale;
import Domain.Sales.SalesLineItem;
import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class SalesTableModel extends AbstractGuiTableModels<Sale> {

    private final String[] columnNames={"Number","Date","Items","Total Price","Payment Method"};
    private final Class[] columnClasses={Integer.class,Date.class,SalesLineItem.class,Float.class,String.class};
    
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
        Sale i=list.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return i.getPayment().getIdPayment();
            case 1:
                return i.getDate();
            case 2:
                return i.getLs();
            case 3:
                return i.getPayment().getAmount();
            case 4:
                return i.getPayment().getPaymentType();
            default:
                return null;
        }
    }
    
}
