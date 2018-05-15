package ua.training;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

public class NumberFormatTag extends SimpleTagSupport {
    private Double number;
    private String format;

    public void setNumber(Double number) {
        this.number = number;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void doTag() throws JspException, IOException {
        double amount = number;
        DecimalFormat formatter = new DecimalFormat(format);
        String formattedNumber = formatter.format(amount);
        getJspContext().getOut().write(formattedNumber);
        super.doTag();
    }
}
