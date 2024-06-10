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
public class WorkShopEvent extends Event {

    public WorkShopEvent() {
        this.setEventActivities(EventType.WORKSHOP.name());
        this.setEventName(EventType.WORKSHOP.name());
        this.setEventDescription(EventType.WORKSHOP.name());
    }

    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Workshop Admission Fee is %.2f", this.getAdmissionFees()));

    }

}
