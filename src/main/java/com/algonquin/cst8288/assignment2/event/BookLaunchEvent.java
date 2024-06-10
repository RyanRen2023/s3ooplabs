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
public class BookLaunchEvent extends Event {

    public BookLaunchEvent() {
        this.setEventActivities(EventType.BOOK_LAUNCH.name());
        this.setEventName(EventType.BOOK_LAUNCH.name());
        this.setEventDescription(EventType.BOOK_LAUNCH.name());
    }

    @Override
    public void calculateAdmissionFee() {
        this.setAdmissionFees(Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION);
        LMSLogger.getLMSLogger().info(String.format("The Book Launch Admission Fee is %.2f", this.getAdmissionFees()));    

    }

}
