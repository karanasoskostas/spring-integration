package pydra.integration.Ebill.Eidop;

public class EidopSQLStatement {
     private String sql = "SELECT    ydr_fdiakopes.id          as id,\n" +
                            "       ydr_fdiakopes.RDIAK_EIDOS as eidos, \n" +
                            "       ydr_fperdiak.rpdiak_descr as descr \n" +
                            "   FROM ydr_fdiakopes inner join ydr_fperdiak on (ydr_fdiakopes.RDIAK_EIDOS = ydr_fperdiak.rpdiak_code)\n" +
                            "where ydr_fdiakopes.DIAKOPES_STATUS = 0";

    public String getSQLStatement(){
        return sql;
    }
}
