/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package cryptoguide;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import cryptoguide.handlers.*;

public class CryptoGuideStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler(),
                        new GetHelpRatesIntentHandler(),
                        new GetHelpPortfolioIntentHandler(),
                        new GetCurrencyRateIntentHandler(),
                        new GetCurrencyCodeIntentHandler(),
                        new GetPortfolioContentIntentHandler(),
                        new AddToPortfolioIntentHandler(),
                        new RemoveFromPortfolioIntentHandler(),
                        new GetPortfolioValueIntentHandler())
                .withTableName("cryptoguideData")
                .withAutoCreateTable(true)
                .withSkillId("amzn1.ask.skill.e8f22f70-b411-48f8-af42-aac285687fa8")
                .build();
    }

    public CryptoGuideStreamHandler() {
        super(getSkill());
    }

}
