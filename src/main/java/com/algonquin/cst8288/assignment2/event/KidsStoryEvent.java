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
public class KidsStoryEvent extends Event {

    public KidsStoryEvent() {
        this.setEventActivities(EventType.KIDS_STORY.name());
        this.setEventName(EventType.KIDS_STORY.name());
        this.setEventDescription(EventType.KIDS_STORY.name());
    }

    @Override
    public void calculateAdmissionFee() {

        this.setAdmissionFees(Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Kids Story Admission Fee is %.2f", this.getAdmissionFees()));

    }

}
