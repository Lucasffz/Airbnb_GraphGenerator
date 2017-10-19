package desafio.poo.controler;
import desafio.poo.model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Photo;
import com.restfb.types.User;

public class Face {
	
	public static void postarNoFb(String token, String path, String nomegrafico, String message, FaceTag photoTag) throws FileNotFoundException{
		String accessToken = token;
		
		ArrayList<FaceTag> myTagList = new ArrayList<FaceTag>();
		myTagList.add(photoTag);		

		@SuppressWarnings("deprecation")
		FacebookClient fb = new DefaultFacebookClient(accessToken);
		
		FileInputStream file = new FileInputStream(new File(path + nomegrafico));
		
		
		@SuppressWarnings("deprecation")
		FacebookType response = fb.publish("me/photos", FacebookType.class, 
				BinaryAttachment.with(nomegrafico, file),
				Parameter.with("message", message),
				Parameter.with("tags", myTagList));
	
	}

}