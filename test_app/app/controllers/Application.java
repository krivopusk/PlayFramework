package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

	public static void getMeridiansConvergence(String Latitude, String Longitude) {
		validation.required(Latitude);
		validation.required(Longitude);
		if(validation.hasErrors()){
		   params.flash();
		   validation.keep();
		   index();
		}
		
        double Lat = Double.parseDouble(Latitude);
		double Lon =  Double.parseDouble(Longitude);
		
		int Zone = (int) Lon / 6;
		double Lon0 = Zone * 6 - 3;
		double Convergence = (Lon - Lon0) * Math.sin(Lat);
		
		render(Convergence);
    }
	

}