package com.bellatrix.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bellatrix.stepDefination.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot  {
	
	public void captureFullPageScreenshot(String fileName) throws IOException {
		//LocalDate currentDate = LocalDate.now();
		//Date dateTime = new Date();
		//Calendar cal = Calendar.getInstance();
		//Date time = cal.getTime();
	///	LocalDateTime time = LocalDateTime.now();
		//LocalTime time2  = LocalTime.now();
	
		AShot ashot = new AShot();
	BufferedImage image =	ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(TestBase.getDriver()).getImage();
	String baseDir= System.getProperty("user.dir");
		ImageIO.write(image, "jpg", new File(baseDir+"/src/test/resources/screenShotFailed/2192023/"+fileName+".jpg"));//currentDate is folder name and dateTime is file Name
		//note failed = testecase name
		
	}
	
	

}
