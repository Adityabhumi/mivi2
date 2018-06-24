package com.android.mivi.net;

import com.android.mivi.model.Attributes;
import com.android.mivi.model.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adi.
 */
public class Utils {

    public static List<Info> getSubProdData(Attributes attributes) {
        List<Info> infos = new ArrayList<>();
        Info info = new Info();
        if (attributes.getIncludedDataBalance()!=null) {
            info.setKey("Data-Balance");
            info.setValue("" + attributes.getIncludedDataBalance());
            infos.add(info);
        }

        if (attributes.getIncludedCreditBalance() != null) {
            info = new Info();
            info.setKey("Credit Balance");
            info.setValue(attributes.getIncludedCreditBalance().toString());
            infos.add(info);
        }

        if (attributes.getIncludedInternationalTalkBalance() != null) {
            info = new Info();
            info.setKey("Talk Balance");
            info.setValue(attributes.getIncludedInternationalTalkBalance().toString());
            infos.add(info);
        }

        if (attributes.getAutoRenewal()!=null && attributes.getAutoRenewal()) {
            info = new Info();
            info.setKey("Auto Renewal");
            info.setValue("" + attributes.getAutoRenewal());
            infos.add(info);
        }

        if (attributes.getExpiryDate() != null && !attributes.getExpiryDate().isEmpty()) {
            info = new Info();
            info.setKey("Expiry Date");
            info.setValue(attributes.getExpiryDate());
            infos.add(info);
        }

        if (attributes.getName()!= null && !attributes.getName().isEmpty()) {
            info = new Info();
            info.setKey("Plan Name");
            info.setValue(attributes.getName());
            infos.add(info);
        }

        if (attributes.getPrice()!= null && attributes.getPrice()!=0) {
            info = new Info();
            info.setKey("Plan Price");
            info.setValue(attributes.getPrice().toString());
            infos.add(info);
        }

        info = new Info();
        if (attributes.getUnlimitedText()!=null && attributes.getUnlimitedText()) {
            info.setKey("Unlimited Text");
            info.setValue("Available");
        } else {
            info.setKey("Unlimited Text");
            info.setValue("Not Available");
        }

        infos.add(info);
        info = new Info();
        if (attributes.getUnlimitedTalk()!=null && attributes.getUnlimitedTalk()) {
            info.setKey("Unlimited Talk");
            info.setValue("Available");
        } else {
            info.setKey("Unlimited Talk");
            info.setValue("Not Available");
        }

        infos.add(info);
        info = new Info();
        if (attributes.getUnlimitedInternationalText()!=null && attributes.getUnlimitedInternationalText()) {
            info.setKey("International Text");
            info.setValue("Available");
        } else {
            info.setKey("International Text");
            info.setValue("Not Available");
        }

        infos.add(info);
        info = new Info();
        if (attributes.getUnlimitedInternationalTalk()!=null && attributes.getUnlimitedInternationalTalk()) {
            info.setKey("International Talk");
            info.setValue("Available");
        } else {
            info.setKey("International Talk");
            info.setValue("Not Available");
        }

        infos.add(info);
        return infos;
    }
}
