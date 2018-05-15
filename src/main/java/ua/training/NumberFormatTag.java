package ua.training.model.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

public class NumberFormatTag extends SimpleTagSupport {
    private String number;
    private String format;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void doTag() throws JspException, IOException {
        double amount = Double.parseDouble(number);
        DecimalFormat formatter = new DecimalFormat(format);
        String formattedNumber = formatter.format(amount);
        getJspContext().getOut().write(formattedNumber);
        super.doTag();
    }
}
