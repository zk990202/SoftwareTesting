package top.kaisir.selenuim;

import java.io.File;
import java.io.FileInputStream;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class TestStudent {
  private WebDriver driver;
  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
//	  baseUrl = "https://www.baidu.com/";
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testStudent() throws Exception {
    driver.get(baseUrl + "/");
    //    WebElement we = driver.findElement(By.id("kw"));
//  we.click();
//  driver.findElement(By.id("kw")).click();
//  driver.findElement(By.id("kw")).clear();
//  driver.findElement(By.id("kw")).sendKeys("天津大学");
//  driver.findElement(By.id("su")).click();
//assertEquals("天津大学_百度搜索", driver.getTitle());

    // 打开Excel文件进行相关操作
    File filePath = new File(System.getProperty("user.dir") + "/src/resources/data/软件测试名单.xlsx");
	FileInputStream file = new FileInputStream(filePath);
	XSSFWorkbook xss = new XSSFWorkbook(file);
	XSSFSheet sheet1= xss.getSheetAt(0);
	int length = sheet1.getPhysicalNumberOfRows()-1;
	for(int i = 2; i < length; i++) {
		// 从Excel中获取学号（取后6位作为密码）、姓名、git地址
		String student_id = sheet1.getRow(i).getCell(1).getRawValue();
		String student_password = student_id.substring(4);
		String student_name = sheet1.getRow(i).getCell(2).getStringCellValue();
		String student_git = sheet1.getRow(i).getCell(3).getStringCellValue();
		
		// 定位到页面中的学号输入框、密码输入框、登录按钮这几个元素
		// 并设置相应的值，进行相关操作
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys(student_id);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(student_password);
		driver.findElement(By.id("btn_login")).click();
		
		// 获取登录后的详情页中的相关数据，并和Excel中的数据对比
		assertEquals(student_id, driver.findElement(By.id("student-id")).getText());
	    assertEquals(student_name, driver.findElement(By.id("student-name")).getText());
	    assertEquals(student_git, driver.findElement(By.id("student-git")).getText());
	    
	    // 登出，返回登录页面
	    driver.findElement(By.id("btn_logout")).click();
	    driver.findElement(By.id("btn_return")).click();
	}
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }


}


