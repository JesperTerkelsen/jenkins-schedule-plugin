/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.deck.jenkins.plugins;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

/**
 *
 * @author jester
 */
@ExportedBean
public class Schedule extends AbstractDescribableImpl<Schedule>{
    @Exported
    public String value;

    public Schedule() {
    }

    @DataBoundConstructor
    public Schedule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
 
    @Extension
    public static class DescriptorImpl extends Descriptor<Schedule> {
        public String getDisplayName() { return ""; }
    }
}
