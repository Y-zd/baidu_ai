import com.yzd.baiduai.service.trans.TransApi;
import com.yzd.baiduai.utils.UnicodeUtil;

/***
 *
 * @author : yanzhidong
 * @date : 2019/8/2 
 * @version : V1.0
 *
 */
public class TransTest {
    public static void main(String[] args) {
        String query = "高度600米";
        String transResult = TransApi.getTransResult(query, "auto", "zh");
        System.out.println(transResult);
        System.out.println(UnicodeUtil.decode(transResult));
    }

}
