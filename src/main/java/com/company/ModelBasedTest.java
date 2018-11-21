  package com.company;

  import core.Inv;
  import org.graphwalker.core.machine.ExecutionContext;
  import org.graphwalker.java.annotation.GraphWalker;

/**
 * See: http://graphwalker.org/docs/maven_archetype for more details
 * <p/>
 * Implements the GraphWalker model: src/main/resources/SmallTest.graphml
 * The SmallTest.graphml can be opened and edited using http://www.yworks.com/en/products/yfiles/yed/
 * <p/>
 * For convienicene, a jpg image exists side-by-side in the same folder.
 * <p/>
 * The @GraphWalker annotation, has the following meaning:
 * 1) value defines the generator of this test. Please read more
 * on the subject at: http://graphwalker.org/docs/path_generators_and_stop_conditions
 * 2) start defines the first element in the model to be executed. (Element is
 * either a vertex or an edge)
 * <p/>
 * The interface SmallTest, that ModelBasedTest implements, is generated by
 * running: mvn graphwalker:generate-sources
 * also: mvn graphwalker:test
 */
@GraphWalker(value = "random(edge_coverage(1000))", start = "e_GoToLoginPage")
public class ModelBasedTest extends ExecutionContext implements SmallTest {
    private Inv inv;

    public ModelBasedTest(){
        inv = new Inv();
        inv.startBrowser("chrome");
    }


  @Override
  public void v_VerifyAtLoginPage() {
      inv.loginPage().verifyCompanyName("QA Ground");


  }

  @Override
  public void v_VerifyAtHomePage() {
      inv.homePage().verifyLoggedUser("karamfilovs@gmail.com");

  }

  @Override
  public void e_ClickHomePageIcon() {
      inv.homePage().clickCompanyLogo();

  }

  @Override
  public void e_Logout() {
      inv.homePage().clickLogoutLink();

  }

  @Override
  public void e_Login() {
      inv.loginPage().login("karamfilovs@gmail.com", "123456");

  }

  @Override
  public void e_GoToLoginPage() {
      inv.loginPage().gotoPage();
  }

    @Override
    public void e_ClickItemLink() {
        inv.itemsPage().clickItemsLink();
    }

    @Override
    public void v_VerifyAtItemsPage() {
        inv.itemsPage().verifyHeadlineText("Артикули");

    }
}