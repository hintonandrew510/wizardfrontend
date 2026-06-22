/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

/**
 *
 * @author andrewhinton
 */
public enum SlidePageNameEnum {
    OnePresentedToSlide("Slide1"),
    TwoTeamCommitmentSlide("Slide2"),
    ThreeMarketPlaceCompetitionSlide("Slide3"),
    FourClientObjectiveSlide("Slide4"),
    FourClientObjectiveTextSlide("Slide 2"),
    FiveStrategicMarketingPageSlide("Slide5"),
    SixTargetMarketingSlide("Slide6"),
    SevenConfidentialClientEvaluationTextSlide("Slide7"),
    EightConfidentialClientEvaluationOneTextSlide("Slide8"),
    NineConfidentialClientEvaluationProposedSlide(""),
    NineConfidentialClientEvaluationProposedTextSlide("Slide9"),
    TwentyOnePlanAMedia("Slide17"),
    NineteenPlanAProposedTextSlide("Slide19"),
    TwentyPlanABEPTextSlide("Slide20"),
    TwentyOnePlanALifetimeValuedTextSlide("Slide21"),
    TwentyTwoPlanADigitalROICalculatorTextSlide("Slide22"),
    TwentyThreePlanBMediaSlide("Slide23"),//TwentyThreePlanBMediaSlide
    EightConfidentialClientEvaluationOneSlide("Weekends are best."),
    SeventeenPlanAMediaSlide(""),
   
    
    //planBBEPPage  planBAverageSale TwentySixPlanBBEPTextSlide 
    
    TwentyFivePlanBProposedTextSlide(""),
  //TwentySixPlanBBEPTextSlide 
  //TwentySixPlanBBEPTextSlide
    TwentySixPlanBBEPTextSlide("Slide26"), //TwentySixPlanBBEPTextSlide
    TwentySevenPlanBBEPTextSlide("Slide27"),
    TwentyEightPlanBLifetimeValuedTextSlide("Slide28"),
    TwentySevenPlanBLifetimeValuedTextSlide("Slide27ddd"), //TwentyEightPlanBLifetimeValuedTextSlide
    TwentyEightPlanBDigitalROICalculatorTextSlide(""),
    TwentyNinePlanASpreadSheetSlide(""),
    TwentyNinePlanASpreadSheetTextSlide("Slide30"),
    ThirtyPlanBSpreadSheetTextSlide("Slide31"),
    ThirtyPlanBSpreadSheetSlide("");

    private final String description;

    // Enum constructors must be private or package-private
    SlidePageNameEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
