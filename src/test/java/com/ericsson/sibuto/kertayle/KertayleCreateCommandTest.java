package com.ericsson.sibuto.kertayle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lmieody on 29/07/16.
 */
public class KertayleCreateCommandTest {

    @Test
    public void toStringShouldReturnCorrectlyFormattedCommand() throws Exception {
        String expectedCommand = "CREATE\n"
                                + "(\n"
                                + "\tparent \"ManagedElement=1,ENodeBFunction=1\"\n"
                                + "\tidentity \"1\"\n"
                                + "\tmoType EUtranCellFDD\n"
                                + ")\n";
        KertayleCreateCommand kertayleCreateCommand =
                new KertayleCreateCommand.Builder().
                        parent("ManagedElement=1,ENodeBFunction=1").
                        identity("1").
                        moType("EUtranCellFDD").
                        build();
        assertEquals(expectedCommand, kertayleCreateCommand.toString());
    }

}