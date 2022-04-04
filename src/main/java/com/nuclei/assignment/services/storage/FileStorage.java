package com.nuclei.assignment.services.storage;

import com.nuclei.assignment.enums.Field;
import com.nuclei.assignment.enums.Order;
import com.nuclei.assignment.exceptions.FileReadException;
import com.nuclei.assignment.exceptions.FileWriteException;
import com.nuclei.assignment.models.User;
import com.nuclei.assignment.utils.CheckEmptyFile;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileStorage implements Storage {
  private final Log logger = LogFactory.getLog(FileStorage.class);
  private final String fileName;

  public FileStorage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void save(List<User> users) throws FileWriteException {
    try (
        FileOutputStream fileOut = new FileOutputStream(this.fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut)
    ) {
      for (User user : users) {
        out.writeObject(user);
      }
    } catch (FileNotFoundException e) {
      logger.error(e.getMessage());
      throw new FileWriteException("cannot find file");
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new FileWriteException("cannot write into the file");
    }
  }

  @Override
  public User read(String rollNum) {
    return null;
  }

  @Override
  public User delete(String rollNum) {
    return null;
  }

  @Override
  public List<User> readAll(Field field, Order order) throws FileReadException {
    List<User> users = new ArrayList<>();
    if (CheckEmptyFile.read(this.fileName)) {
      return users;
    }
    try (
        FileInputStream fileIn = new FileInputStream(this.fileName);
        ObjectInputStream in = new ObjectInputStream(fileIn)
    ) {

      while (true) {
        Object obj = in.readObject();
        if (obj == null) {
          break;
        }
        users.add((User) obj);
      }
    } catch (EOFException e) {
      System.out.println("users fetched");
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new FileReadException("cannot read file");
    }
    return users;
  }
}
