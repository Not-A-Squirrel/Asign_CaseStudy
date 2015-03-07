package caseStudy.animation; 

import caseStudy.AnimationBase;
import caseStudy.IConstants;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public final class Spring extends AnimationBase{
    
    double mass;
    double period;
    double springConstant;
    double amplitude;
    ImageView spring;
    Circle hangingMass;
    
    public Spring(){
        
        TextField[] fields = new TextField[3];
        for(int i = 0 ; i <= 3 ; i++){
            fields[i] = new TextField("3.00");
        //0 -> massField
        //1 -> constantield
        //2 -> amplitudeField
        }
        
        setMass(Double.parseDouble(fields[0].getText()));
        setSpringConstant(Double.parseDouble(fields[1].getText()));
        setAmplitude(Double.parseDouble(fields[2].getText()));
        period = calculatePeriod();
        //placeholder.setCycleDuration(new Duration(period*1000)); //not sure what is happening here
        
        Image springGraphic = new Image("SpringCaseStudy.png"); //idk if this works
        spring = new ImageView(springGraphic);
        spring.setFitHeight(100);
        spring.setPreserveRatio(true);
        spring.setSmooth(true);
        
        hangingMass = new Circle(/* x and y positions here*/ 30.00);
    }
    
    public double calculatePeriod(){
        return 2*IConstants.PI*Math.sqrt(getMass()/getSpringConstant());
    }
    
    public void calculateKeyfames(){
        double stretchPercent = 0.00;
        //adds the keyframes to the timeline
        for(int i = 0 ; placeholder.getCycleDuration().greaterThan(new Duration(i*33)) ; i++){
            //calculate percent extension
            stretchPercent = 1+Math.cos((i*33/1000)*Math.sqrt(springConstant/mass));
            //spring
            spring.setFitHeight((stretchPercent*0.6+20)*spring.getFitHeight()); //this should be adding a keyframe
            //mass
                //move the circle
        }
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpringConstant(double springConstant) {
        this.springConstant = springConstant;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getPeriod() {
        return period;
    }

    public double getMass() {
        return mass;
    }

    public double getSpringConstant() {
        return springConstant;
    }

    public double getAmplitude() {
        return amplitude;
    }
}
