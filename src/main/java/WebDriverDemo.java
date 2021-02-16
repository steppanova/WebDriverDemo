
public class WebDriverDemo {
    public String findInBrowse(SearchDetails search) {
        String failed = "failed";
        String passed= "Поиск";

        if(search.getBrowserName()==null && search.getFindWord()==null&& search.getProperty()==null){
            return failed;
        }else
           return passed;

    }
}
