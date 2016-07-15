    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextPath}/home">KZNConnect</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${contextPath}/home">Home</a>
                    </li>
                    <li>
                        <a href="${contextPath}/blogs">Blog</a>
                    </li>
                    <li>
                        <a href="${contextPath}/forums">Forum</a>
                    </li>
                    <sec:authorize access="isAuthenticated() and hasRole('ROLE_USER')">
	                    <li>
	                        <a href="${contextPath}/user/dashboard">My Profile</a>
	                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
	                    <li>
						 <a href="" class="dropdown-toggle" data-toggle="dropdown">Admin <b class="caret"></b></a>
			              <ul class="dropdown-menu">
			                <li><a href="${contextPath}/admin/categories/view">Categories</a></li>
			                <li><a href="${contextPath}/admin/forums/view">Forums</a></li>
		                  </ul>	                        
	                    </li>
                    </sec:authorize>

                    <li>
                        <a href="${contextPath}/about">About</a>
                    </li>
                    <li>
                        <a href="${contextPath}/contact">Contact</a>
                    </li>
                    <sec:authorize access="isAnonymous()">
	                    <li>
	                        <a href="${contextPath}/login">
	                        	<span class="glyphicon glyphicon-lock"></span> Login
	                        </a>
	                    </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
	                    <li>
	                        <a href="${contextPath}/logout">
	                        	<span class="glyphicon glyphicon-off"></span> Logout
	                        </a>
	                    </li>
                    </sec:authorize>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
