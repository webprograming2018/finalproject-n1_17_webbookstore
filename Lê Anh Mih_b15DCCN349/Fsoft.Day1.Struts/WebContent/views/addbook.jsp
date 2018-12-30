<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <div class="container">
            <div class="form center-block">
                <form method="POST">
                    <h3 class="form-heading">
                        <c:choose>
                            <c:when test="${book!=null}">
                                Edit book
                            </c:when>
                            <c:otherwise>
                                Add new book
                            </c:otherwise>z
                        </c:choose>
                    </h3>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="title" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="text" required name="title" placeholder="Book title"
                            id="title">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="author" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="text" required name="author" placeholder="Book Author"
                            id="author">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="isbn" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="text" required name="isbn" placeholder="Book ISBN"
                            id="isbn">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="releaseDate" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="date" required
                            name="releaseDate" placeholder="Release Date" id="releaseDate">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="publisher" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="text" required name="publisher"
                            placeholder="Publisher" id="publisher">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="price" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="text" required name="price" placeholder="Price"
                            id="price">
                    </div>
                    <div class="form-group col-md-8 col-lg-8">
                        <label for="image" class="right"></label>
                        <input class="left col-md-4 col-lg-4 form-control" type="file" readonly required data-allowed-file-extensions='["jpg", "png"]'
                            name="price" placeholder="Choose file" id="image">
                    </div>

                </form>
            </div>
        </div>