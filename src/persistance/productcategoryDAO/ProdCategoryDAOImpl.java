package persistance.productcategoryDAO;

import persistance.JDBCController;
import shared.transfer.products.ProductCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdCategoryDAOImpl implements ProdCategoryDAO
{
  private static ProdCategoryDAOImpl prodCategoryInstance;
  private JDBCController controller;

  private ProdCategoryDAOImpl()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    controller = JDBCController.getInstance();
  }

  public static synchronized ProdCategoryDAOImpl getInstance()
  {
    if (prodCategoryInstance == null)
    {
      prodCategoryInstance = new ProdCategoryDAOImpl();
    }
    return prodCategoryInstance;
  }

  @Override public String addNewCategory(String prodCategory_id,
      String categoryName, String categoryDescription)
  {
    String newCategory = null;
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO ProductCategory(prodCategory_id, categoryName, categoryDescription) VALUES(?,?,?); ");
      statement.setString(1, prodCategory_id);
      statement.setString(2, categoryName);
      statement.setString(3, categoryDescription);
      statement.executeQuery();

      /*newCategory =  new ProductCategory(prodCategory_id, categoryName,
          categoryDescription);*/
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return newCategory;
  }


  @Override public List<ProductCategory> viewAllCategoriesByName(
      String searchCriteria)
  {
    ArrayList<ProductCategory> result = new ArrayList<>();
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM ProductCategory WHERE categoryName LIKE ?");
      statement.setString(1, "%" + searchCriteria + "%");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        String prodCategory_id = resultSet.getString("prodCategory_id");
        String categoryName = resultSet.getString("categoryName");
        String categoryDescription = resultSet.getString("categoryDescription");
        ProductCategory category = new ProductCategory(prodCategory_id,
            categoryName, categoryDescription);
        result.add(category);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }

  @Override public void updateCategory(ProductCategory category)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE ProductCategory SET prodCategory = ?, categoryName = ?, categoryDescription = ?");
      statement.setString(1, category.getProdCategory_id());
      statement.setString(2, category.getCategoryName());
      statement.setString(3, category.getCategoryDescription());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void deleteCategory(ProductCategory category)
  {
    try (Connection connection = controller.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM ProductCategory WHERE prodCategory_id = ?");
      statement.setString(1, category.getProdCategory_id());
      statement.executeUpdate();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
