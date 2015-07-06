package org.batfish.question;

import java.util.List;

import org.batfish.main.BatfishLogger;
import org.batfish.main.Settings;
import org.batfish.representation.Configuration;

public class ForEachNodeStatement implements Statement {

   List<Statement> _statements;

   public ForEachNodeStatement(List<Statement> statements) {
      _statements = statements;
   }

   @Override
   public void execute(Environment environment, BatfishLogger logger,
         Settings settings) {
      for (Configuration node : environment.getNodes()) {
         Environment statementEnv = environment.copy();
         statementEnv.setNode(node);
         for (Statement statement : _statements) {
            statement.execute(statementEnv, logger, settings);
         }
      }
   }

}