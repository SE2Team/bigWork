package businesslogic.managebl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import dataservice.managedataservice.ManageDataService;
import po.*;
import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class Manage {
    /**
     * The Manage.
     */
    private ManageDataService manage;
    private InquiryDataService inquiryDataService;

    /**
     * Instantiates a new Manage.
     *
     * @throws RemoteException the remote exception
     */
    public Manage() throws RemoteException {

        DataFactoryService dataFactory = DataFactory.getInstance();
        manage = dataFactory.getManageData();
        inquiryDataService=dataFactory.getInquiryData();
    }

    /**
     * Add driver boolean.
     *
     * @param driverVO the driver vo
     * @return the boolean
     * @throws RemoteException the remote exception
     * @throws ExistException  the exist exception
     */
    public boolean addDriver(DriverVO driverVO) throws RemoteException, ExistException {
        DriverPO po = new DriverPO(driverVO.getDriverNum(), driverVO.getDriverName(), driverVO.getBirthDate(), driverVO.getIdNum(),
                driverVO.getPhone(), driverVO.getVehicleInstitution(), driverVO.getSex(), driverVO.getLicenseTime());

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "新增司机信息"));
        return manage.addDriver(po);
    }

    /**
     * Del driver result message.
     *
     * @param driverVO the driver vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public Boolean delDriver(DriverVO driverVO) throws RemoteException {

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "删除司机信息"));
        return manage.deleteDriver(convert(driverVO));
    }

    public Iterator<DriverVO> checkDriver() throws RemoteException {
        ArrayList<DriverPO> itr=manage.checkDriver();
        ArrayList<DriverVO> arrayList=new ArrayList<DriverVO>();

        for(DriverPO temp:itr){
            arrayList.add(PO2VO.convert(temp));
        }


        return arrayList.iterator();
    }

    /**
     * Check driver driver vo.
     *
     * @param driveNumber the drive number
     * @return the driver vo
     * @throws RemoteException the remote exception
     */
    public DriverVO checkDriver(String driveNumber) throws RemoteException {

        return convert(manage.checkDriver(driveNumber));
    }

    /**
     * Add vehicle result message.
     *
     * @param vehicleVO the vehicle vo
     * @return the result message
     * @throws RemoteException the remote exception
     * @throws ExistException  the exist exception
     */
    public Boolean addVehicle(VehicleVO vehicleVO) throws RemoteException, ExistException {
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "增加车辆信息"));
        return manage.addVehicle(convert(vehicleVO));
    }

    /**
     * Del vehicle result message.
     *
     * @param vehiclevO the vehiclev o
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public Boolean delVehicle(VehicleVO vehiclevO) throws RemoteException {
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "删除车辆信息"));
        return manage.deleteVehicle(convert(vehiclevO));
    }

    /**
     * show all Vehivles info
     * @return
     * @throws RemoteException
     */
    public Iterator<VehicleVO> checkVehicle() throws RemoteException {
        ArrayList<VehiclePO> itr=manage.checkVehicle();
        ArrayList<VehicleVO> arrayList=new ArrayList<VehicleVO>();
        for(VehiclePO temp:itr){
            arrayList.add(PO2VO.convert(temp));
        }
        return arrayList.iterator();
    }

    /**
     * Check vehicle vehicle vo.
     *
     * @param vehicleNumber the vehicle number
     * @return the vehicle vo
     * @throws RemoteException the remote exception
     */
    public VehicleVO checkVehicle(String vehicleNumber) throws RemoteException {
        return convert(manage.checkVehicle(vehicleNumber));
    }

    /**
     * Update salary.
     *
     * @param position the position
     * @param Type     the type
     * @throws RemoteException the remote exception
     */
    public void updateSalary(String position, String Type) throws RemoteException {
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "更新薪水策略"));
        manage.updateSalary(position,Type);
    }

    public String getSalary(String position) throws RemoteException {
        return manage.getSalary(position);
    }
    /**
     *
     * @param constantVO
     * @throws RemoteException
     * @throws ExistException
     */
    public void updateConstant(ConstantVO constantVO) throws RemoteException, ExistException {

        ConstantPO po = new ConstantPO(constantVO.getCity1(), constantVO.getCity2(), constantVO.getPrice(), constantVO.getDistance());
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "更新城市距离价格信息"));

        manage.updateConstant(po);
    }

    public boolean addWorker(WorkerVO vo) throws RemoteException, ExistException {
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "增加人员机构信息"));
        return manage.addWorker(VO2PO.convert(vo));
    }

    public boolean delWorker(WorkerVO vo) throws RemoteException, ExistException {
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "删除人员机构信息"));
        return manage.delWorker(VO2PO.convert(vo));
    }

    public Iterator<WorkerVO> checkWorker() throws RemoteException {
        ArrayList<WorkerPO> itr=manage.checkWorker();
        ArrayList<WorkerVO> arrayList=new ArrayList<WorkerVO>();
        for(WorkerPO temp:itr){
            arrayList.add(PO2VO.convert(temp));
        }
        return arrayList.iterator();
    }

    public Iterator<WorkerVO> checkWorker(String name) throws RemoteException {

        ArrayList<WorkerPO> itr=manage.checkWorker(name);
        ArrayList<WorkerVO> arrayList=new ArrayList<WorkerVO>();
        for(WorkerPO temp:itr){
            arrayList.add(PO2VO.convert(temp));
        }

        return arrayList.iterator();
    }

    public WorkerVO checkWorkerByID(String id) {
        return PO2VO.convert(manage.checkWorkerByID(id));
    }

    public boolean editWorker(WorkerVO opo,WorkerVO npo) throws RemoteException, ExistException {
        return manage.editWorker(VO2PO.convert(opo),VO2PO.convert(npo));
    }

    public Iterator<ConstantVO> checkConstant() throws RemoteException {
        ArrayList<ConstantVO> arrayList = new ArrayList<ConstantVO>();
        for (ConstantPO po : manage.getConstant()) {
            arrayList.add(PO2VO.convert(po));
        }
        return arrayList.iterator();
    }

    public boolean editDriver(DriverVO ovo, DriverVO nvo) throws RemoteException, ExistException {
        return manage.editDriver(VO2PO.convert(ovo), VO2PO.convert(nvo));
    }

    public boolean editVehicle(VehicleVO ovo, VehicleVO nvo) throws RemoteException, ExistException {
        return manage.editVehicle(VO2PO.convert(ovo), VO2PO.convert(nvo));
    }

    public Iterator<OrganizationVO> checkOrganization() throws RemoteException {
        ArrayList<OrganizationVO> arrayList = new ArrayList<OrganizationVO>();
        for (OrganizationPO po : manage.check()) {
            arrayList.add(PO2VO.convert(po));
        }
        return arrayList.iterator();
    }

    public boolean addOrganization(OrganizationVO vo) throws RemoteException, ExistException {
        return manage.addOrganization(VO2PO.convert(vo));
    }

    public boolean delOrganization(OrganizationVO vo) throws RemoteException, ExistException {
        return manage.delOrganization(VO2PO.convert(vo));
    }

    /**
     * 私有vo和po之间转换的方法
     *
     * @param driverVO
     * @return
     */
    private DriverPO convert(DriverVO driverVO) {
        return new DriverPO(driverVO.getDriverNum(), driverVO.getDriverName(), driverVO.getBirthDate(), driverVO.getIdNum(),
                driverVO.getPhone(), driverVO.getVehicleInstitution(), driverVO.getSex(), driverVO.getLicenseTime());
    }

    private DriverVO convert(DriverPO driverPO) {
        return new DriverVO(driverPO.getDriverNum(), driverPO.getDriverName(), driverPO.getBirthDate(), driverPO.getIdNum(),
                driverPO.getPhone(), driverPO.getVehicleInstitution(), driverPO.getSex(), driverPO.getLicenseTime());
    }

    private VehicleVO convert(VehiclePO vehiclePO) {
        return new VehicleVO(vehiclePO.getVehicleNum(), vehiclePO.getLicensePlate(), vehiclePO.getBuyDate(), vehiclePO.getUseTime());
    }

    private VehiclePO convert(VehicleVO vehicleVO) {
        return new VehiclePO(vehicleVO.getVehicleNum(), vehicleVO.getLicensePlate(), vehicleVO.getBuyDate(), vehicleVO.getUseTime());
    }

}
