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
    OnePresentedToSlide("Slide 1"),
    TwoTeamCommitmentSlide("Slide 2"),
    ThreeMarketPlaceCompetitionSlide("Slide 3"),
    FourClientObjectiveSlide("Slide 2"),
    FourClientObjectiveTextSlide("Slide 2"),
    FiveStrategicMarketingPageSlide("Slide 2"),
    SixTargetMarketingSlide("Weekends are best."),
    SevenConfidentialClientEvaluationTextSlide(""),
    EightConfidentialClientEvaluationOneTextSlide(""),
    NineConfidentialClientEvaluationProposedSlide(""),
    NineConfidentialClientEvaluationProposedTextSlide(""),
    EightConfidentialClientEvaluationOneSlide("Weekends are best."),
    SeventeenPlanAMediaSlide(""),
    TwentyPlanABEPTextSlide(""),
    TwentyOnePlanALifetimeValuedTextSlide(""),
    TwentyTwoPlanADigitalROICalculatorTextSlide(""),
    TwentyThreePlanBMediaSlide(""),
    TwentyFivePlanBProposedTextSlide(""),
    TwentySixPlanBBEPTextSlide(""),
    TwentySevenPlanBLifetimeValuedTextSlide(""),
    TwentyEightPlanBDigitalROICalculatorTextSlide(""),
    TwentyNinePlanASpreadSheetSlide(""),
    TwentyNinePlanASpreadSheetTextSlide(""),
    ThirtyPlanBSpreadSheetTextSlide(""),
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
