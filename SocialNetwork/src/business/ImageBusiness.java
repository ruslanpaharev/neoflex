package business;

import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageBusiness {

	public static byte[] getImageIcon(byte[] imgArray){
		
		int miniWidth = 240;
		int miniHeight = 180;
				
		ByteArrayInputStream input = new ByteArrayInputStream(imgArray);
		BufferedImage fullImage = null;
		
		try {
			fullImage = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		BufferedImage miniImage;
		miniImage = new BufferedImage(miniWidth, miniHeight, fullImage.getType());
	
		
		AffineTransform transform = new AffineTransform(
		        ((double) miniWidth) / fullImage.getWidth(), 0, 0,
		        ((double) miniHeight) / fullImage.getHeight(), 0, 0);
		AffineTransformOp transformer = new AffineTransformOp(transform, new RenderingHints(
		        RenderingHints.KEY_INTERPOLATION,
		        RenderingHints.VALUE_INTERPOLATION_BICUBIC));
		
		transformer.filter(fullImage, miniImage);
		
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageIO.write(miniImage, "JPEG", output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output.toByteArray();
	}
	
}
