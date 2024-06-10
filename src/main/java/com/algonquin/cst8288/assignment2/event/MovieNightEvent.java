/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;

/**
 *
 * @author renxihai
 */
public class MovieNightEvent extends Event {

    public MovieNightEvent() {
        this.setEventActivities(EventType.MOVIE_NIGHT.name());
        this.setEventName(EventType.MOVIE_NIGHT.name());
        this.setEventDescription(EventType.MOVIE_NIGHT.name());
    }

    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Movie Night Admission Fee is %.2f", this.getAdmissionFees()));    
    }

}
