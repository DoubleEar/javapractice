package standard;

public interface HttpServletRequest extends ServletRequest {
    String getMethod();

    String getPath();

    String getParameter(String name);

    String getHeader(String name);

}
