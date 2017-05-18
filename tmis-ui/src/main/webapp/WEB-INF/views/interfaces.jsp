<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>首页-接口服务</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="/" class="site_title"><i class="fa fa-paw"></i> <span>接口服务</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/alvin.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>欢迎,</span>
                <h2>Alvin</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>基本服务</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i>系统面板  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/">接口监控</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i>接口列表 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li class="current-page"><a href="/interfaces">所有接口</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>接口文档 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/interface_docs">查看文档</a></li>
                      <li><a href="#">新建文档</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i>接口测试<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/interface_test">所有接口</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-clone"></i>接口扩展<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/interface_extend">新增接口</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>附加服务</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i>信息维护</a></li>         
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/alvin.jpg" alt="">Alvin
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;">个人资料</a></li>
                    <li>
                      <a href="javascript:;">
                        <!-- <span class="badge bg-red pull-right">50%</span> -->
                        <span>设置</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i>注销</a></li>
                  </ul>
                </li>

              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>接口服务列表</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      展示服务器中所有已注册的接口服务。</code>
                    </p>
                    <table id="datatable-checkbox" class="table table-striped table-bordered bulk_action">
                      <thead>
                        <tr>
                          <th>
               <th><input type="checkbox" id="check-all" class="flat"></th>
              </th>
                          <th>接口服务名</th>
                          <th>接口路径</th>
                        </tr>
                      </thead>
                      <tbody>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>userAuthService</td>
                        <td>com.neoalvin.tmis.api.IUserAuthService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>userAuthRestService</td>
                        <td>com.neoalvin.tmis.api.IUserAuthRestService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>zookeeperService</td>
                        <td>com.neoalvin.tmis.api.IZookeeperService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>zookeeperRestService</td>
                        <td>com.neoalvin.tmis.api.IZookeeperRestService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>kafkaSendMessageService</td>
                        <td>com.neoalvin.tmis.api.IKafkaSendMessageService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>kafkaSubscribeMessageService</td>
                        <td>com.neoalvin.tmis.api.IKafkaSubscribeMessageService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>taskManageService</td>
                        <td>com.neoalvin.tmis.api.ITaskManageService</td>
                      </tr>
                      <tr>
                        <td>
                        <th><input type="checkbox" id="check-all" class="flat"></th>
                        </td>
                        <td>taskManageRestService</td>
                        <td>com.neoalvin.tmis.api.ITaskManageRestService</td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            接口服务管理 - www.neoalvin.com/ism <a href="https://www.neoalvin.com">Alvin</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="./vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="./vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="./vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="./vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="./vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="./vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="./vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="./vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="./vendors/Flot/jquery.flot.js"></script>
    <script src="./vendors/Flot/jquery.flot.pie.js"></script>
    <script src="./vendors/Flot/jquery.flot.time.js"></script>
    <script src="./vendors/Flot/jquery.flot.stack.js"></script>
    <script src="./vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="./vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="./vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="./vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="./vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="./vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="./vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="./vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="./vendors/moment/min/moment.min.js"></script>
    <script src="./vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="./build/js/custom.min.js"></script>
	
  </body>
</html>
