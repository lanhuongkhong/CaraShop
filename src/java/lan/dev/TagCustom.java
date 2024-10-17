package lan.dev;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class TagCustom extends SimpleTagSupport {

    private String name;
    private String time;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // Kiểm tra nếu `name` là null hoặc rỗng.
            if (name == null || name.isEmpty()) {
                name = "no name";
            }

            // In ra `name`.
            out.println("Tên: " + name + "<br/>");

            // Nếu `time` không phải là null hoặc rỗng, định dạng và in ra ngày tháng.
            if (time != null && !time.isEmpty()) {
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat(time);
                String formattedDate = dateFormat.format(date);
                out.println("Ngày: " + formattedDate + "<br/>");
            }

            // Thực thi nội dung bên trong Custom Tag nếu có.
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in TagCustom tag", ex);
        }
    }

    // Setters để truyền các thuộc tính từ trang JSP.
    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
