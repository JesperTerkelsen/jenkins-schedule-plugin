/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.deck.jenkins.plugins;

import antlr.ANTLRException;
import hudson.Extension;
import hudson.model.BuildableItem;
import hudson.model.Item;
import hudson.triggers.TimerTrigger;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 *
 * @author jester
 */
public class ScheduledTrigger extends Trigger<BuildableItem> {
    protected static Logger LOGGER = Logger.getLogger(ScheduledTrigger.class.getName());
    
    private List<Schedule> executeOn = new ArrayList<Schedule>();
    
    @DataBoundConstructor
    public ScheduledTrigger(String cronTabSpec, List<Schedule> executeOn) throws ANTLRException{
        super(cronTabSpec); // Check every second
        this.executeOn = executeOn;
    }

    public List<Schedule> getExecuteOn() {
        return executeOn;
    }
   
    @Override
    public void run() {
        LOGGER.info("Checking schedule for " + job.getName());
        job.scheduleBuild(0, new TimerTrigger.TimerTriggerCause());
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }
    
    @Extension
    public static final class DescriptorImpl extends TriggerDescriptor {

        @Override
        public boolean isApplicable(Item item) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Build when scheduled";
        }
        
    }

}
