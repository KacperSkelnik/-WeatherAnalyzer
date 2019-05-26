package frames;

//Kacper Skelnik

public class OutfitGuide {
	
	Language language = new Language();
	
	String shoes, hat, clothes, accessories;
	boolean danger = false;
	
	public OutfitGuide() throws Exception {
		WeatherYdnJava date = new WeatherYdnJava();
		
		if(date.status == 5 || date.status == 6 || date.status == 7 || date.status == 8 || date.status == 9 
		|| date.status == 10 || date.status == 11 || date.status == 12 || date.status == 17 || date.status == 18
		|| date.status == 35 || date.status == 40 ) {
			accessories = language.Res.getString("umbrella");
		}
		else if((date.status == 32 || date.status == 34) && Float.parseFloat(date.WindChill.replace(",",".")) >= 18) {
			accessories = language.Res.getString("sunglasses");
		}	
		else if(date.status == 0 || date.status == 1 || date.status == 2 || date.status == 3 || date.status == 42 || date.status == 4) {
			shoes = language.Res.getString("better");
			hat = language.Res.getString("stay");
			clothes = language.Res.getString("at");
			accessories = language.Res.getString("home");
			danger = true;
		}
		else{
			accessories = language.Res.getString("a_lot_of_smile");
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 5 && accessories != "parasol" && danger != true) {
			shoes = language.Res.getString("warm_shoes");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 5 && Float.parseFloat(date.WindChill.replace(",",".")) <= 12 
				&& accessories != "parasol" && danger != true){
			shoes = language.Res.getString("shoes");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 12 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100 
				&& accessories != "parasol" && danger != true){
			shoes = language.Res.getString("trainers");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) >= 5 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100 
				&& accessories == "parasol" && danger != true){
			shoes = language.Res.getString("wellingtons");
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 7 && danger != true) {
			hat = language.Res.getString("warm_hat");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 7 && Float.parseFloat(date.WindChill.replace(",",".")) <= 20 
				&& danger != true){
			hat = language.Res.getString("baseball_cap");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 20 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100
				&& danger != true){
			hat = language.Res.getString("straw_hat");
		}
		
		
		
		if(Float.parseFloat(date.WindChill.replace(",", ".")) <= 0 && danger != true) {
			clothes = language.Res.getString("warm_jacket");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 0 && Float.parseFloat(date.WindChill.replace(",",".")) <= 8 
				&& danger != true){
			clothes = language.Res.getString("coat");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 8 && Float.parseFloat(date.WindChill.replace(",",".")) <= 15
				&& danger != true && accessories != "parasol"){
			clothes = language.Res.getString("jacket");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 15 && Float.parseFloat(date.WindChill.replace(",",".")) <= 20
				&& danger != true && accessories != "parasol"){
			clothes = language.Res.getString("hoodie");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 20 && Float.parseFloat(date.WindChill.replace(",",".")) <= 24
				&& danger != true && accessories != "parasol"){
			clothes = language.Res.getString("shirt");
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 24 && Float.parseFloat(date.WindChill.replace(",",".")) <= 35
				&& danger != true){
			clothes = "t-shirt";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 35 && Float.parseFloat(date.WindChill.replace(",",".")) <= 100
				&& danger != true){
			clothes = "( ͡° ͜ʖ ͡°)";
		}
		else if(Float.parseFloat(date.WindChill.replace(",", ".")) > 8 && Float.parseFloat(date.WindChill.replace(",",".")) <= 24
				&& accessories == "parasol" && danger != true){
			clothes = language.Res.getString("rain_jacket");
		}
	}
}
