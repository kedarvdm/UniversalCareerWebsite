<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST" action="deleteEmployee">
	<table class="table table-striped table-bordered table-hover">
		<tbody>
			<tr>
				<th class="text-center">First Name</th>
				<th class="text-center">Last Name</th>
				<th class="text-center">Department</th>
				<th class="text-center">Update Profile</th>
				<th class="text-center">Delete?</th>
			</tr>
			<c:forEach var="employee" items="${employer.employees}">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.department}</td>
					<td class="text-center"><a href="updateEmployee?id=${employee.id}" class="btn btn-primary">Update</a></td>
					<td class="text-center"><input type="checkbox" name="deleteselected" value="${employee.id}"></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="text-center">
					<input type="submit" name="delete" value="Delete?" class="btn btn-danger"/>
				</td>
			</tr>
		</tbody>
	</table>
</form>