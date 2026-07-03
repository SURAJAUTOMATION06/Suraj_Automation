package org.example;

import jakarta.mail.*;
import jakarta.mail.search.FlagTerm;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailutils {

    public static String getOtpFromEmail(String host, String user, String password) {
        try {
            // 1. Setup properties for IMAP
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            props.put("mail.imaps.host", host);
            props.put("mail.imaps.port", "993");
            props.put("mail.imaps.ssl.enable", "true");

            // 2. Connect to the session
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host, user, password);

            // 3. Open the Inbox
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE); // Use READ_WRITE to mark as seen

            // 4. Search for unread messages
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            if (messages.length == 0) {
                System.out.println("No unread emails found.");
                return null;
            }

            // Get the latest message
            Message latestMessage = messages[messages.length - 1];
            String content = latestMessage.getContent().toString();

            // 5. Extract 6-digit OTP using Regex
            Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
            Matcher matcher = pattern.matcher(content);

            if (matcher.find()) {
                return matcher.group(0);
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Example: Gmail host is imap.gmail.com
        String otp = getOtpFromEmail("imap.gmail.com", "surajspawar06@gmail.com", "rxgb iskl kghq fbxp");
        System.out.println("Extracted OTP: " + otp);
    }
}