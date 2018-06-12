import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:20 18-6-12
 * simplify-path：我的解法
 **/
public class T78 {

    public String simplifyPath(String path) {
        if (path==null||path.equals(""))
            return "";

        String[] p=path.split("/");
        List<String> res=new ArrayList<>();
        for (int i=0;i<p.length;i++){
            if (p[i].equals("")||p[i].equals("."))
                continue;
            else if (p[i].equals("..")){
                if (res.size()>0)
                    res.remove(res.size()-1);
                else continue;
            }else res.add(p[i]);
        }
        StringBuilder sb=new StringBuilder();
        for (String s:res)
            sb.append("/"+s);
        if (sb.length()>0)
            return sb.toString();
        else return "/";
    }

    public static void main(String[] args){
        T78 t=new T78();
        String path="/home//foo/";
        System.out.println(t.simplifyPath(path));
    }
}
