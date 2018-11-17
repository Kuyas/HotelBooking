import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AmountPaid{
  public static int Span(String[] args)
  {
    Date sqlDate = new Date(System.currentTimeMillis());
    String checkIn = args[0];
    Date start = Date.valueOf(checkIn);
    long  Duration = start.getTime() - sqlDate.getTime();
    if (Duration >0 )
    {
      long days = Duration/(24*60*60*1000);
      if (days<=3)
      {
        return  1;
      }
      else
      {
        return 0;
      }
    }
    else
    {
      return -1;
    }
  }
}
//  public static void main(String[] args) {
//    
//  }
//}
