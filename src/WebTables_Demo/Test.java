package WebTables_Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) {

		System.out.println("Dynamic webtable in CrickBuzz Website");

		System.setProperty("webdriver.chrome.driver",
				"C:\\ChromeDriver File\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/91641/srh-vs-lsg-57th-match-indian-premier-league-2024");

		// to find the inning number one Player Score

		WebElement inning1 = driver.findElement(By.xpath("//div[@id='innings_1']/child :: div[1]"));
		String str1 = inning1.getText();
		System.out.println(str1);
		System.out.println();
		List<WebElement> data1 = inning1.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms'] "));
		System.out.println("Inning 1 Count :- " + data1.size());

		// In Inning 1 Player Name and total Number Of Batsman.
		WebElement inning11 = driver.findElement(By.xpath("//div[@id='innings_1']/child :: div[1]"));
		List<WebElement> pin11 = inning11.findElements(
				By.xpath("//div[@id='innings_1']/div[1]/child :: div/div[contains (@class, 'cb-col')]/a"));
		int lengin11 = pin11.size();
		System.out.println("Total Number Of Player In Inning 1st = " + lengin11);

		for (int i = 0; i < lengin11; i++) {
			System.out.println("In For Loop 'A'");
			String pname11 = inning11.findElements(By.cssSelector("#innings_1 > div:nth-child(1) > div a")).get(i)
					.getText();
			String p11 = inning11.findElements(By.cssSelector("[class='cb-ico cb-caret-right']")).get(0).getText();
			if (!p11.equals(" ")) {
				System.out.println("Player Name In Inning 1st = " + pname11);
				System.out.println();
			} else {
				break;
			}

		}

		String totalrun = driver.findElement(By.xpath("//div[text()=' 165 ']")).getText();
		System.out.println("Ininning 1st Total Run : "+totalrun);
		driver.close();

	}

}
